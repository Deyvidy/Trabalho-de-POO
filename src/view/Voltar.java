package view;

import view.ItensDoMenu;

public class Voltar extends ItensDoMenu {
    @Override
    public String descricao() {
        return "Voltar";
    }

    @Override
    public boolean executar() {
            return true;
    }

}