package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.services.items.BuscarItemPorId;
import es.acaex.biblioteca.services.items.CrearCopiaEnElemento;
import es.acaex.biblioteca.services.items.GuardarItem;
import es.acaex.biblioteca.services.items.ListarCopiasDeElemento;
import es.acaex.biblioteca.services.items.ListarInventario;

@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    ListarInventario listarInventario;
    @Autowired
    GuardarItem guardarItem;
    @Autowired
    BuscarItemPorId buscarItemPorId;
    @Autowired
    CrearCopiaEnElemento crearCopiaEnElemento;
    @Autowired
    ListarCopiasDeElemento listarCopiasDeElemento;

    @GetMapping
    public List<Item> get() {
        return listarInventario.execute();
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return guardarItem.execute(item);
    }

    @GetMapping("{itemId}")
    public Item findBy(@PathVariable("itemId") Long itemId) {
        return buscarItemPorId.execute(itemId);
    }

    @PostMapping("{itemId}/copies")
    public Copy crearCopia(@PathVariable("itemId") Long itemId) {
        return crearCopiaEnElemento.execute(itemId);
    }

    @GetMapping("{itemId}/copies")
    public List<Copy> listarCopias(@PathVariable("itemId") Long itemId) {
        return listarCopiasDeElemento.execute(itemId);
    }
}
