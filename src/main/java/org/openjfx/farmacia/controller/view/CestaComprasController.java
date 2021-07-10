package org.openjfx.farmacia.controller.view;

import org.openjfx.farmacia.controller.produto.ProdutoCesta;

import java.util.ArrayList;

public class CestaComprasController {
    ArrayList<ProdutoCesta> cestaCompras;

    public CestaComprasController() {
        this.cestaCompras = new ArrayList<>();
        
    }

    public ArrayList<ProdutoCesta> getCestaCompras() {
        return cestaCompras;
    }

    @SuppressWarnings("unused")
    public void setCestaCompras(ArrayList<ProdutoCesta> cestaCompras) {
        this.cestaCompras = cestaCompras;
    }

    public void abrirCesta() {
       
    }
}
