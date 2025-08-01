import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Painel from "./pages/Painel";
import Caixa from "./pages/Caixa";
import Cabecalho from "./components/Cabecalho";
import Estoque from "./pages/Estoque";

function App() {
  return (
    <BrowserRouter>
      <div className="container">
        <div className="shadow-container">
          <Cabecalho />
          <Routes>
            <Route path="/" element={<Painel />} />
            <Route path="/caixa" element={<Caixa />}/>
            <Route path="/estoque" element={<Estoque />}/>
          </Routes>
        </div>
        
      </div>
    </BrowserRouter>
  )
}

export default App
