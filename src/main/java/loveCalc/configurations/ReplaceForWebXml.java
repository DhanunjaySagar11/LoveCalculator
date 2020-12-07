package loveCalc.configurations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ReplaceForWebXml implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("In Replace for webxml");
		/*
		 * //in XML way XmlWebApplicationContext wac = new XmlWebApplicationContext();
		 * wac.setConfigLocation("classPath:application-config.xml");
		 */
		AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
		wac.register(ReplaceForBeanFile.class);
		DispatcherServlet ds = new DispatcherServlet(wac);
		
	ServletRegistration.Dynamic myCustomDs= servletContext.addServlet("myds",ds);

	myCustomDs.setLoadOnStartup(1);
	myCustomDs.addMapping("/first/*");
	}

}
