import ProdutoEstoque from "../../components/ProdutoEstoque";
import "./Estoque.css";
import { useState } from "react";
import ModalAddProduto from "../../components/ModalAddProduto";
import ModalEditProduto from "../../components/ModalEditProduto";

function Estoque() {
    const [isVisble1, setIsVisible1] = useState(false);
    const [isVisible2, setIsVisible2] = useState(false);

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

                <button className="botao__cadastrar-produto" onClick={() => setIsVisible1(true)}>Cadastrar Produto</button>
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
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50} setIsVisible2={setIsVisible2}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50} setIsVisible2={setIsVisible2}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50} setIsVisible2={setIsVisible2}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50} setIsVisible2={setIsVisible2}/>
                <ProdutoEstoque codBarras={"A1F98AD"} nome="Coca Cola 2L" categoria={"bebidas"} quantidade={10} preco={50} setIsVisible2={setIsVisible2}/>
            </div>

            {
                isVisble1 ? <ModalAddProduto setIsVisible1={setIsVisible1}/> : null
            }
            {
                isVisible2 ? <ModalEditProduto setIsVisible2={setIsVisible2}/> : null
            }
        </div>
    )
}

export default Estoque;