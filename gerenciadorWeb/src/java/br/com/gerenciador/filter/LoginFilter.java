/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.filter;

import br.com.gerenciador.entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danieldruszcz
 */
public class LoginFilter implements javax.servlet.Filter, Serializable{
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
         if (session != null) {
            Usuario loggedUser = (Usuario) session.getAttribute("logged_user");
            if (loggedUser != null && loggedUser.getId() != 0) {
                chain.doFilter(request, response);
                return;
            }
        }
        ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/pages/login.xhtml");
    }

    @Override
    public void destroy() {
        
    }

}
