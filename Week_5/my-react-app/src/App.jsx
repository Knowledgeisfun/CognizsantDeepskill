import React from "react";
import DeveloperBios from './DeveloperBios';

function App() {    
    const items = ['Apple', 'Banana', 'Cherry'];
    const users = [{id: 1, firstName: 'sanjay vinod', lastName: 'k', langauge: 'java', year: 2023 },
                  {id: 2, firstName: 'vinod paul', lastName: 'k', langauge: 'python', year: 1999 }
    ]    
    return (        
        <div>            
            <h1>My Fruit List</h1>            
            <ul>                
                {items.map((item, index) => (                    
                    <li key={index}>{item}</li>                
                ))}            
            </ul> 

            <h1>Developer Bios</h1>    
            <ul>
              {users.map((user) => (
                <li key={user.id}> <DeveloperBios 
                        firstname={user.firstName} 
                        lastName={user.lastName} 
                        langauge={user.langauge} 
                        year={user.year} 
                    />
                  </li>
              ))}
            </ul>   
        </div>    );
}

export default App;