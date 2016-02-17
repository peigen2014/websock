package com.pg.html5.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		VersionResourceResolver versionResolver = new VersionResourceResolver().addContentVersionStrategy("/**");

		registry.addResourceHandler("/websocket/**").addResourceLocations("classpath:/templates/")
				.resourceChain(true).addResolver(versionResolver);
	}
}
