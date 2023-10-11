import React, {Component} from "react";
import Navigation from "./navigation.component";

export default class TodoLists extends Component{
    render(){
        return(
            <div>
                <Navigation />
                <h1>Welcome to To Do List</h1>
            </div>
        )
    }
}