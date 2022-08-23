import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import Table from "react-bootstrap/Table";
import axios from "axios";
import Button from 'react-bootstrap/Button';
import {Link} from 'react-router-dom'
export default function ViewPatients() {
    const [patients, setPatients]=useState([]);

    useEffect(()=>{
        axios.get("http://localhost:8080/listofpatients")
            .then(response=>setPatients(response.data))
            .catch(error=>alert(error));
    })

    let deletepatient=(id,event)=>{
        event.preventDefault();
        axios.delete("http://localhost:8080/patient/"+id)
            .then(response=>{alert(response.data)})
            .catch(error=>alert(error));
    }
    return (
        <Card className="my-4">
            <Card.Header>List Of patients Information</Card.Header>
            <div>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>patient ID</th>
                        <th>patient Name</th>
                        <th>patient Age</th>
                        <th>patient Address</th>
                        <th>Edit/Delete patient</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        patients.map((patient)=>
                            <tr key={patient.id}>
                                <td>{patient.id}</td>
                                <td>{patient.name}</td>
                                <td>{patient.age}</td>
                                <td>{patient.address}</td>

                                <td>
                                    <Link to={"/updatePatient/"+patient.id}>
                                        <Button variant="primary">Edit</Button></Link> {' '}
                                    <Button variant="danger" onClick={deletepatient().bind(this,patient.id)}>Delete</Button>{' '}
                                </td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            </div>
            <Card.Footer>This is the patient Information Page</Card.Footer>
        </Card>
    );
}