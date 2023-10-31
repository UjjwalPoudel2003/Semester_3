import React from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
} from "react-router-dom";
import Product from "./components/product.js";
import Shop from "./components/shop.js";

function App() {
  return (
    <div>
    <Router>
        <ul>
          <li>
            <Link to="/">New Shop</Link>
          </li>
          <li>
            <Link to="/product">New Product</Link>
          </li>
        </ul>
        <Routes>
          <Route exact path="/" element={< Shop />} />
          <Route exact path="/product" element={< Product />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;