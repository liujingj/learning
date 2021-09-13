package com.ljj.malllearning;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Indexed;

@Profile("dev")
@Configuration
@Indexed
public class WebConfiguration {
}


