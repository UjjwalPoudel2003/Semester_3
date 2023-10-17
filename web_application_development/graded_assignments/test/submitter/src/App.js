import React from "react";
import { BrowserRouter as Link, Router, Route, Routes } from "react-router-dom";
import Product from "./components/product.component";
import Shop from "./components/shop.component";

function App() {
  return (
    <router>
      <>
        <nav className="navigation">
          <Link to={'/'} className="navigation__link">New Shop</Link>
          <Link to={'/product'} className="navigation__link">New Product</Link>
        </nav>
      <Router>
      <Routes>
        <Route path="/" element={<Shop />}></Route>
        <Route path="/product" element={<Product />}></Route>
      </Routes>
      </Router>
      </>
    </router>
  );
}

export default App;