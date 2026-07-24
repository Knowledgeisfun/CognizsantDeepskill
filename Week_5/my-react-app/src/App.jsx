import React, { useState } from "react";
import DeveloperBios from './DeveloperBios';
import AddDeveloperForm from "./AddDeveloperForm";

function App() {    
    // 1. Matched the state variable name to 'developers'
    const [developers, setDevelopers] = useState([
        { id: 1, firstName: "Sanjay Vinod", lastName: "K", language: "Java", year: "3" },
        { id: 2, firstName: "Ada", lastName: "Lovelace", language: "Analytical Engine", year: "10" }
    ]);

    // 2. The handler function now correctly references 'developers'
    const handleAddDeveloper = (newDeveloper) => {
        setDevelopers([...developers, newDeveloper]);
    };
    
    const learningJourney = [
        { id: 1, title: 'React', focus: 'Functional Component, BootStrap' },
        { id: 2, title: 'Cloud Infrastructure Integration', focus: 'AWS EC2, S3, RDS' },
        { id: 3, title: 'Oracle Certified Professional', focus: 'Java SE 17 Developer' }
    ];

    return (        
        <div className="container py-5">
            <div className="row mb-5 text-center">
                <div className="col">
                    <h1 className="display-4 fw-bold text-black">My Developer Portfolio</h1>
                    <p className="lead text-muted">Documenting my engineering journey and projects.</p>
                </div>
            </div>

            <div className="row">
                <div className="col-md-5">
                    <h3 className="mb-3 border-bottom pb-2">Developer Profile</h3>
                    
                    {/* 3. Render the form so it actually appears on screen! */}
                    <AddDeveloperForm onAdd={handleAddDeveloper} />
                    
                    {/* 4. Map over 'developers' and fix prop spelling */}
                    {developers.map((user) => (
                        <DeveloperBios 
                            key={user.id}
                            firstName={user.firstName} 
                            lastName={user.lastName} 
                            language={user.language} 
                            year={user.year} 
                        />
                    ))}
                </div>

                <div className="col-md-7">
                    <h3 className="mb-3 border-bottom pb-2">Recent Milestones</h3>
                    <ul className="list-group shadow-sm">
                        {learningJourney.map((item) => (
                            <li key={item.id} className="list-group-item d-flex justify-content-between align-items-center p-3">
                                <span className="fw-semibold">{item.title}</span>
                                <span className="badge bg-info text-dark rounded-pill">{item.focus}</span>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>    
    );
}

export default App;