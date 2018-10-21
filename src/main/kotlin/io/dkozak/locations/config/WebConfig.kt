package io.dkozak.locations.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver


@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurerAdapter() {

    @Bean
    fun getViewResolver(): ViewResolver {
        return InternalResourceViewResolver().apply {
            setPrefix("/WEB-INF/")
            setSuffix(".html")
        }
    }

    override fun configureDefaultServletHandling(
            configurer: DefaultServletHandlerConfigurer) {
        // https://stackoverflow.com/questions/29953245/configure-viewresolver-with-spring-boot-and-annotations-gives-no-mapping-found-f
        configurer.enable()
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
    }
}