import { useState } from "react";

const AddDeveloperForm = ({ onAdd }) => {
  // Create state for each input field
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [language, setLanguage] = useState("");
  const [year, setYear] = useState("");

  // What happens when the user clicks submit
  const handleSubmit = (event) => {
    event.preventDefault(); // Stops the page from refreshing

    // Package the current state into a new object
    const newDev = {
      id: Date.now(), // Generate a random ID for the list key
      firstName: firstName,
      lastName: lastName,
      language: language,
      year: year
    };

    // Send it back up to App.jsx
    onAdd(newDev);

    // Clear the form fields by resetting the state to empty strings
    setFirstName("");
    setLastName("");
    setLanguage("");
    setYear("");
  };

  return (
    <form onSubmit={handleSubmit} className="card p-3 bg-light mb-4">
      <div className="mb-2">
        <label className="form-label">First Name</label>
        <input 
          type="text" 
          className="form-control"
          value={firstName} 
          onChange={(e) => setFirstName(e.target.value)} // Update state as you type
          required 
        />
      </div>
      
      <div className="mb-2">
        <label className="form-label">Last Name</label>
        <input 
          type="text" 
          className="form-control"
          value={lastName} 
          onChange={(e) => setLastName(e.target.value)} 
          required 
        />
      </div>

      <div className="mb-2">
        <label className="form-label">Primary Language</label>
        <input 
          type="text" 
          className="form-control"
          value={language} 
          onChange={(e) => setLanguage(e.target.value)} 
          required 
        />
      </div>

      <div className="mb-3">
        <label className="form-label">Years of Experience</label>
        <input 
          type="number" 
          className="form-control"
          value={year} 
          onChange={(e) => setYear(e.target.value)} 
          required 
        />
      </div>

      <button type="submit" className="btn btn-primary">Add Developer</button>
    </form>
  );
};

export default AddDeveloperForm;