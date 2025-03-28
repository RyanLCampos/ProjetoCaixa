import "./Caixa.css";
import ProdutoCaixa from "../../components/ProdutoCaixa";

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
            <div className="caixa--venda-container">
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
                <div className="caixa--venda-container--produtos">
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                    <ProdutoCaixa codBarras={"A1F98AD"} nome="Coca Cola 2L" quantidade={10} preco={50}/>
                </div>
            </div>
            <div className="caixa--forma-de-pagamento">
                <form>
                    <div className="div--forma-pagamento">
                        <label htmlFor="formaPagamento">Forma de pagamento</label>
                        <select name="formaPagamento" id="formaPagamento">
                            <option value="0">Pix</option>
                            <option value="1">Dinheiro</option>
                            <option value="2">Cartão</option>
                        </select>
                    </div>

                    <button type="submit" className="botao-vender">Vender</button>
                </form>
            </div>
        </div>
    )
}

export default Caixa;