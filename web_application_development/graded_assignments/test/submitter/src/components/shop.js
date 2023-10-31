import React, { useState } from "react";
import '../styles/style.css';

const Shop = () => {
    const [file, setFile] = useState(null);
    const[name, setName] = useState('Your name here');
    const[description, setDescription] = useState('Your description here');

    const handleFile = (event) => {
        const selectedFile = event.target.files[0];
        setFile(selectedFile);
    }

    const handleName = (event) => {
        const newName = event.target.value;
        setName(newName);
    }

    const handledescription = (event) => {
        const newDescription = event.target.value;
        setDescription(newDescription);
    }

    const setToNull = () => {
        setName(null);
        setDescription(null);
        setFile(null);
        window.location.reload();
    }

    return (
        <div className="form-body">
            <h1>New Shop</h1>
            <div className="upload">
                <label>File Upload</label>
                <input type="file" name="filename"></input>
            </div>

            <div className="details">
                <div className="details-detail">
                    <label>Name: </label>
                    <input type="text" value={name} onChange={handleName}/>
                </div>

                <div className="details-detail">
                    <label>description: </label>
                    <input type="text" value={description} onChange={handledescription}/>
                </div>
            </div>

            <div className="form-footer">
                <button type="reset" onClick={setToNull}>SUBMIT</button>
                <button type="reset" onClick={setToNull}>CANCEL</button>
            </div>
        </div>
    ) 
}

export default Shop;