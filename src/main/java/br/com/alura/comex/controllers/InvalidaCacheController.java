package br.com.alura.comex.controllers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSB2ZW5kYXM")
public class InvalidaCacheController {

    @GetMapping
    @CacheEvict(value = "relatorioPedidos", allEntries = true)
    public void invalidaCache() {}

}
