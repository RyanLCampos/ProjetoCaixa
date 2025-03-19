import { BrowserRouter, Routes, Route } from "react-router-dom";
import Painel from "./pages/Painel";
import Caixa from "./pages/Caixa";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Painel />} />
        <Route path="/caixa" element={<Caixa />}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
