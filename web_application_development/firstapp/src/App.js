import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import TodoLists from "./components/todolists.component";
import EditList from "./components/editlist.component";
import AddTodo from "./components/addtodo.component";


function App() {
  return(
    <Router>
      <Routes>
        <Route path="/" Component={TodoLists}/>
        <Route path="/edit/:id" Component={EditList}/>
        <Route path="/add" Component={AddTodo}/>
      </Routes>
    </Router>
  )
}

export default App;