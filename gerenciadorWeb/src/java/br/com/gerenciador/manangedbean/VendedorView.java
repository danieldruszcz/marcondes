package br.com.gerenciador.manangedbean;

import br.com.gerenciador.entity.Vendedor;
import br.com.gerenciador.util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "vendedorView")
@ViewScoped
public class VendedorView {

    private Vendedor vendedor;

    @PostConstruct
    public void init() {
        this.vendedor = new Vendedor();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void salvar() throws IOException {
        Gson g = new Gson();
        String teste = g.toJson(this.vendedor);
        System.out.println("Teste " + teste);
        Util.sendPost("vendedor/salvar", teste);
    }
    
}
