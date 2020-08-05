package com.atguigu.web;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 实现注册和登录的服务器连接器
 *
 * @author shkstart
 * @create 2020-07-30 16:53
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 注销
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁session中的用户登录信息
        req.getSession().invalidate();
        //2.重定向到首页
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 处理登录功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于 null,说明登录 失败!
        if (loginUser == null) {
            // 跳回登录页面,登录失败
            //把错误信息,和会显示的信息保存到request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);

            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);

        } else {
            // 登录 成功
            //保存用户登录的信息session域中
            req.getSession().setAttribute("user", loginUser);
            // 跳到成功页面 login_success.jsp
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        }
    }


    /**
     * 处理注册功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        // 1、获取请求的参数,表单的提交地址给过来(regist.jsp)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 2、检查 验证码是否正确 === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)) {
            //3、正确检查 用户名是否可用
            if (userService.existsUsername(username)) {
                // 不可用跳回注册页面
                System.out.println("用户名[" + username + "]已存在!");
                // 不可用跳回注册页面
                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在!!!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            } else {
                // 可用
                // 调用 Sservice 保存到数据库
                userService.registUser(new User(null, username, password, email));
                // 跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            // 不可用跳回注册页面
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误!!!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }


}



    