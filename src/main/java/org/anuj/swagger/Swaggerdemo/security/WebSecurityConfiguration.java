package org.anuj.swagger.Swaggerdemo.security;

/*import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
      .antMatchers(
        "/v2/api-docs",
        "/swagger-resources/**",
        "/swagger-ui.html**",
        "/webjars/**");
  }
}*/
/*@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) throws Exception {
    http
    .csrf().disable()
      .exceptionHandling()
      .authenticationEntryPoint(unauthorizedHandler)
      .accessDeniedHandler(accessDeniedHandler)
      .and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
      //.antMatchers("/actuator/**").permitAll()
      .antMatchers("/actuator/**").hasAuthority("ADMIN")
      .antMatchers(
        HttpMethod.GET,
        "/v2/api-docs",
        "/swagger-resources/**",
        "/swagger-ui.html**",
        "/webjars/**",
        "favicon.ico"
      ).permitAll()
      .antMatchers("/auth/**").permitAll()
      .anyRequest().authenticated();

    http
      .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
      .headers()
      .cacheControl();
  }
}*/