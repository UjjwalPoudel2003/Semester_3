import React from "react";
import { BrowserRouter as Link, Router, Route, Routes } from "react-router-dom";
import Product from "./components/product.js";
import Shop from "./components/shop.component";

function App() {
  return (
    <Router>
        <nav className="navigation">
          <Link to={'/'} className="navigation__link">New Shop</Link>
          <Link to={'/product'} className="navigation__link">New Product</Link>
        </nav>
      <Routes>
        <Route path='/' element={<Shop />} />
        <Route path='/product' element={<Product />} />
      </Routes>
    </Router>
  );
}

export default App;