import React, { useState } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';
import axios from 'axios';

const PopupFormEdit= ({ show, handleClose,setItems }) => {
  const [item, setItem] = useState({
    id:'',
    name: '',
    boh: '',
    price: '',
  });

  const { name, boh, price } = item;

  const onInputChange = (e) => {
    setItem({ ...item, [e.target.name]: e.target.value });
  };

  const handlePostRequest = () => {
    axios.put(`http://localhost:8080/item/${item.id}`, {
        name: item.name,
        boh: item.boh,
        price: item.price
    })
      .then((response) => {
        console.log('Item updated successfully:', response.data);
        // If you want to refresh the items after updating
        axios
          .get('http://localhost:8080/Stock')
          .then(response => setItems(response.data))
          .catch(error => console.error('Error fetching data:', error));
        // Close the modal after a successful update
        handleClose();
      })
      .catch((error) => console.error('Error updating item:', error));
  };
  
  const handleSubmit = (e) => {
    e.preventDefault();
    handlePostRequest();
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Edit item Form</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form onSubmit={handleSubmit}>
          <Form.Group control="name">
            <Form.Label>Name</Form.Label>
            <Form.Control
              type="text"
              placeholder={item.name}
              name="name"
              value={name}
              onChange={onInputChange}
            />
          </Form.Group>

          <Form.Group controlId="boh">
            <Form.Label>BOH</Form.Label>
            <Form.Control
              type="text"
              placeholder={item.boh}
              name="boh"
              value={boh}
              onChange={onInputChange}
            />
          </Form.Group>

          <Form.Group controlId="price">
            <Form.Label>Price</Form.Label>
            <Form.Control
              type="text"
              placeholder={item.price}
              name="price"
              value={price}
              onChange={onInputChange}
            />
          </Form.Group>

          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
};

export default PopupFormEdit;