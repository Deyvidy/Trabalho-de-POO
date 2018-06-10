package model;

import view.ItensDoMenu;

public class Sair extends ItensDoMenu {
    @Override
    public String descricao() {
        return "Sair";
    }

    @Override
    public boolean executar() {
            return true;
    }

}