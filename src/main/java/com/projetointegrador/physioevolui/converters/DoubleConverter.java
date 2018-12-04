/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author murilo
 */
@Component
@ConfigurationPropertiesBinding
public class DoubleConverter implements Converter<Double, String> {

    @Override
    public String convert(Double s) {
        // 3.10 = 3.1
        // 3.00 = 3.0
        String doubleString = s + "";
        String decimais = doubleString.substring(doubleString.indexOf("."), doubleString.length() - 1);
        if (decimais.length() < 3) {
            return doubleString + "0";
        } else {
            return doubleString;
        }
    }

}
