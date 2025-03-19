import "./Caixa.css";

function Caixa() {
    return (
        <div className="tela-container caixa">
            <h1>Caixa</h1>
            <div className="caixa--inputs">
                <form>
                    <div className="caixa--inputs-inputs">
                        <div>
                            <label htmlFor="codBarras">Código de barras</label>
                            <input className="input-cod-barras" type="text" name="codBarras" id="codBarras"/>
                        </div>
                        
                        <div>
                            <label htmlFor="quantidade">Quantidade</label>
                            <input className="input-quantidade" type="number" name="quantidade" id="quantidade" />
                        </div>
                    </div>
                    <div className="caixa--inputs-botoes">
                        <button className="buscar-nome">Buscar por nome</button>
                        <button type="submit" className="adicionar">Adicionar</button>
                    </div>
                </form>
            </div>
            <scroll className="caixa--venda-container">
                <div className="caixa--venda-container-legenda">
                    <div className="legenda-esquerda">
                        <span>Código de barras</span>
                        <span>Produto</span>
                    </div>

                    <div className="legenda-direita">
                        <span>Quantidade</span>
                        <span>Preço</span>
                        <span>Ações</span>
                    </div>
                </div>
            </scroll>
            <div className="caixa--forma-de-pagamento">

            </div>
        </div>
    )
}

export default Caixa;