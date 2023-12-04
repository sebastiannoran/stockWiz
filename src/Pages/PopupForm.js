import React, { useState } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';
import axios from 'axios';

const PopupForm = ({ show, handleClose,setItems }) => {
  const [item, setItem] = useState({
    name: '',
    boh: '',
    price: '',
  });

  const { name, boh, price } = item;

  const onInputChange = (e) => {
    setItem({ ...item, [e.target.name]: e.target.value });
  };

  const handlePostRequest = () => {
    axios
      .post('http://localhost:8080/item', item)
      .then((response) => {
        console.log('Item added successfully:', response.data);
        // If you want to refresh the items after adding a new one
        axios
        .get('http://localhost:8080/Stock')
        .then(response => setItems(response.data))
        .catch(error => console.error('Error fetching data:', error))
      })
      .catch((error) => console.error('Error adding item:', error));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    handlePostRequest();
    handleClose();
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>add item Form</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="name">
            <Form.Label>Name</Form.Label>
            <Form.Control
              type="text"
              placeholder="Name of Item"
              name="name"
              value={name}
              onChange={onInputChange}
            />
          </Form.Group>

          <Form.Group controlId="boh">
            <Form.Label>BOH</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter BOH"
              name="boh"
              value={boh}
              onChange={onInputChange}
            />
          </Form.Group>

          <Form.Group controlId="price">
            <Form.Label>Price</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter Price"
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

export default PopupForm;