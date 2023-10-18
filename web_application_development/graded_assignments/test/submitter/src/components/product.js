import React, { useState } from "react";

const Product = () => {
    const[file, setFile] = useState(null);
    const[name, setName] = useState('your name here');
    const[description, setDescription] = useState("Your description here");
    const[category, setCategory] = useState('Your category here');
    const[quantity, setQuantity] = useState('Your quantity here');
    const[price, setPrice] = useState('Your price here');

    const handleFile = (event) => {
        const selectedFile = event.target.files[0];
        setFile(selectedFile);
    }

    const handleName = (event) => {
        const newName = event.target.value;
        setName(newName);
    }

    const handleDescription = (event) => {
        const newDescription = event.target.value;
        setDescription(newDescription);
    }

    const handleCategory = (event) => {
        const newCategory = event.target.value;
        setCategory(newCategory);
    }

    const handleQuantity = (event) => {
        const newQuantity = event.target.value;
        setQuantity(newQuantity);
    }

    const handlePrice = (event) => {
        const newPrice = event.target.value;
        setPrice(newPrice);
    }

    return (
        <div>
            <h1>New Shop</h1>
            <div className="upload">
                <label>Upload LOGO</label>
                <input type="file" value={file} onChange={handleFile} />
            </div>

            <div className="details">
                <div className="details-detail">
                    <label>Name: </label>
                    <input type="text" value={name} onChange={handleName}/>
                </div>

                <div className="details-detail">
                    <label>Description: </label>
                    <input type="text" value={description} onChange={handleDescription}/>
                </div>

                <div className="details-detail">
                    <label>Category: </label>
                    <input type="text" value={category} onChange={handleCategory}/>
                </div>

                <div className="details-detail">
                    <label>Quantity: </label>
                    <input type="text" value={quantity} onChange={handleQuantity}/>
                </div>

                <div className="details-detail">
                    <label>Price: </label>
                    <input type="text" value={price} onChange={handlePrice}/>
                </div>
            </div>
        </div>
    ) 
}

export default Product;