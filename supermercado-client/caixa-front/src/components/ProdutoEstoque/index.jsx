import "./ProdutoEstoque.css";
import { FaTrashCan, FaPen } from "react-icons/fa6";
import { Link } from "react-router-dom";

function ProdutoEstoque({ codBarras, nome, categoria, preco, quantidade, setIsVisible2 }) {
    return (
        <div className="produto-estoque">
            <div className="produto-estoque--esquerda">
                <p>{codBarras}</p>
                <p>{nome}</p>
                <p>{categoria}</p>
            </div>
            <div className="produto-estoque--direita">
                <p>{quantidade} unidades</p>
                <p>R$ {preco.toFixed(2)}</p>
                <div className="produto-estoque--direita-acoes">
                    <Link onClick={() => setIsVisible2(true)} className="icon-caneta"><FaPen /></Link>
                    <Link className="icon-lixeira"><FaTrashCan /></Link>
                </div>
            </div>
        </div>
    )
}

export default ProdutoEstoque;