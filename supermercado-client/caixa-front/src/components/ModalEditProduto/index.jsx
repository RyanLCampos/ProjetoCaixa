function ModalEditProduto({ setIsVisible2 }) {
    return (
        <div className="modal-container">
            <div className="modal-add-produto">
                <button className="modal--add-produto__cancelar" onClick={() => setIsVisible2(false)}>Cancelar</button>
                <h1>Edição de produto</h1>
                <form>
                    <div className="div-linhas">
                        <div className="div-linhas__inputs">
                            <label htmlFor="codBarras">Código de barras</label>
                            <input type="text" id="codBarras" />
                        </div>
                        <div className="div-linhas__inputs">
                            <div className="input-categoria">
                                <label htmlFor="categoria">Categoria</label>
                                <button>+</button>
                            </div>
                            <select name="categoria" id="categoria">
                                <option value="0">Bebidas</option>
                                <option value="1">Alimentos</option>
                                <option value="2">Outros</option>
                            </select>
                        </div>
                    </div>
                    <div className="div-linhas">
                        <div className="div-linhas__inputs">
                            <label htmlFor="nomeProduto">Nome do produto</label>
                            <input type="text" id="nomeProduto" />
                        </div>
                        <div className="div-linhas__inputs">
                            <label htmlFor="preco">Preço unitário</label>
                            <input type="number" id="preco" />
                        </div>
                    </div>
                    <div className="div-linhas">
                        <div className="div-linhas__inputs">
                            <label htmlFor="quantidadeMinima">Quantidade mínima estoque</label>
                            <input type="number" id="quantidadeMinima" />
                        </div>
                        <div className="div-linhas__inputs">
                            <label htmlFor="quantidade">quantidade</label>
                            <input type="number" id="quantidade" />
                        </div>
                    </div>
                    <button type="submit">Editar produto</button>
                </form>
            </div>
        </div> 
    )
}

export default ModalEditProduto;