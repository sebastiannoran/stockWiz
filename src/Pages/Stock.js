// App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import PopupForm from './PopupForm.js';
import PopupFormEdit from './PopupFormEdit.js';
import { Modal, Button, Form } from 'react-bootstrap';

const App = () => {
    const [items, setItems] = useState([]);
    const [selectedItemId, setSelectedItemId] = useState(null);
    const [showForm, setShowForm] = useState(false);

    const handleShowForm = () => setShowForm(true);
    const handleCloseForm = () => setShowForm(false);
    

    // Fetch data on component mount
    useEffect(() => {
        axios.get('http://localhost:8080/Stock')
            .then(response => setItems(response.data))
            .catch(error => console.error('Error fetching data:', error));
    }, []);



    return (

        <div>
            <h1>Items on hand</h1>
            <div>
      <button onClick={handleShowForm}>add item</button>
      <PopupForm show={showForm} handleClose={handleCloseForm}setItems={setItems} />
    </div>
            <table className="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>price</th>
                        <th>boh</th>
                        <th>DateAdded</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    
                    {items.map(item => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.price}</td>
                            <td>{item.boh}</td>
                            <td>{item.dateAdded}</td>
                            <button onClick={()=>handleShowForm(item.id)}>Edit</button>
                            <td><PopupFormEdit show={showForm} handleClose={handleCloseForm}itemId={selectedItemId}setItems={setItems} />
                            <button className="edit_btn">Delete</button></td>
                            
                        </tr>

                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default App;
