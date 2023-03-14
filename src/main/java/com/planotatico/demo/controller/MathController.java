package com.planotatico.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planotatico.demo.converters.NumberConverter;
import com.planotatico.demo.math.SimpleMath;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();



    // Soma dois numeros
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo

    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    // Subtrai dois numeros
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo

    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.sub(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    // Multiplica dois numeros
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo

    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.mult(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    // Eleva dois numeros
    @RequestMapping(value = "/eleva/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double fraci(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo

    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.eleva(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));

    }

    // Divide dois numeros
    @RequestMapping(value = "/divi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divi(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo

    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.divi(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));

    }

    // Média de dois numeros
    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo

    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.med(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));

    }

    // Raiz quadrada numeros
    @RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
    public Double raiz(
            @PathVariable(value = "number") String number

    ) throws Exception {
        if (!NumberConverter.isNumeric(number) || !NumberConverter.isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return math.raiz(NumberConverter.convertToDouble(number));

    }

}
