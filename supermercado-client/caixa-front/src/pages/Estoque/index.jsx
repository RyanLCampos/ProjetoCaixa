import ProdutoEstoque from "../../components/ProdutoEstoque";
import "./Estoque.css";
import { Link } from "react-router-dom";

function Estoque() {
    return (
        <div className="tela-container estoque">
            <h1 className="titulo">Estoque</h1>
            <div className="estoque__area-filtros">
                <div>
                    <select name="filtros" id="filtros">
                        <option value="0">Nome</option>
                        <option value="1">Unidades</option>
                        <option value="2">Preço</option>
                    </select>
                    <label htmlFor="filtros">Adicionar filtros</label>
                </div>

                <Link to="/cadastrar-produto" className="botao__cadastrar-produto">Cadastrar Produto</Link>
            </div>

            <div className="estoque__legenda">
                <div className="estoque__legenda--esquerda">
                    <span>Código de barras</span>
                    <span>Produto</span>
                    <span>Categoria</span>
                </div>
                <div className="estoque__legenda--direita">
                    <span>Quantidade</span>
                    <span>Preço Unitário</span>
                    <span>Ações</span>
                </div>
            </div>

            <div className="estoque__lista-produtos">
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50}/>
            </div>
        </div>
    )
}

export default Estoque;