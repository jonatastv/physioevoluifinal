package com.projetointegrador.physioevolui.converters;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.projeto.estoque.cdm.converters;
//
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author Murilo Oliveira
// */
//@Component
//@ConfigurationPropertiesBinding
//public class StringDoubleConverter implements Converter<String, Double> {
//
//    @Override
//    public Double convert(String s) {
//        if (s.contains(".") && s.contains(",")) {
//            System.out.println("CONVERTENDO ESSA MERDA " + s);
//            String str = s.replaceAll(".", "");
//            System.out.println("Aqui " + str + " - " + s);
//            str = str.replaceAll(",", ".");
//            System.out.println("Aqui 2 " + str + " - " + s);
//
//            return Double.parseDouble(str);
//        } else {
//            System.out.println("Não converteu " + s);
//            return Double.parseDouble(s);
//        }
//    }
//
//}
