package com.planotatico.demo.services;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter{

    protected YamlJackson2HttpMesageConverter() {
        super(new YAMLMapper().
        
        
        setSerializationInclusion(J),
        MediaType.parseMediaType("application/x-yaml"));
    }
    
}
