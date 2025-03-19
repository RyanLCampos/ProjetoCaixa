import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Painel from "./pages/Painel";
import Caixa from "./pages/Caixa";
import Cabecalho from "./components/Cabecalho";

function App() {
  return (
    <BrowserRouter>
      <div className="container">
        <Cabecalho />
        <Routes>
          <Route path="/" element={<Painel />} />
          <Route path="/caixa" element={<Caixa />}/>
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App
