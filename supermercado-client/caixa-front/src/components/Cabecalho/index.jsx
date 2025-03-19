import "./Cabecalho.css";
import { NavLink } from "react-router-dom";

function Cabecalho() {
    return (
        <header className="cabecalho">
            <h1>LOGO</h1>
            <div className="cabecalho--links">
                <NavLink to="/" className={({ isActive }) => 
                    isActive ? "navlink--ativo" : "navlink"
                }>Painel</NavLink>
                <NavLink to="/estoque" className={({ isActive }) => 
                    isActive ? "navlink--ativo" : "navlink"
                }>Estoque</NavLink>
                <NavLink to="/caixa" className={({ isActive }) => 
                    isActive ? "navlink--ativo" : "navlink"
                }>Caixa</NavLink>

                <div>
                    <NavLink to="/perfil" className={({ isActive }) => 
                        isActive ? "navlink--ativo" : "navlink"
                    }>Perfil</NavLink>
                </div>
            </div>
        </header>
    )
}

export default Cabecalho;