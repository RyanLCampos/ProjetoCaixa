import "./ProdutoCaixa.css";

function ProdutoCaixa({ codBarras, nome, quantidade, preco }){
    return (
        <div className="produto-caixa">
            <div className="produto-caixa--esquerda">
                <p>{codBarras}</p>
                <p>{nome}</p>
            </div>
            <div className="produto-caixa--direita">
                <p>{quantidade} unidades</p>
                <p>R$ {preco.toFixed(2)}</p>
                <div className="produto-caixa--direita-acoes">
                    <button>-</button>
                    <button>+</button>
                </div>
            </div>
        </div>
    )
}

export default ProdutoCaixa;