import React, { Component } from "react";
import { BrowserRouter as Link } from "react-router-dom";

export default class Navigation extends Component {
    render() {
        return (
            <nav className="navigation">
                <Link className="navigation-link_home" to={"/"}>
                    Home
                </Link>
                <Link className="navigation-link_home" to={"/add"}>
                    Add
                </Link>
            </nav>
        )
    }
}