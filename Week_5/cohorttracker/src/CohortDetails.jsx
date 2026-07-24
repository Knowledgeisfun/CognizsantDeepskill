import React from 'react';
// Import the CSS Module
import styles from './CohortDetails.module.css';

export const CohortDetails = ({ code, name, startDate, status, coach, trainer }) => {
    // Define the style for <h3> element based on the cohort status[cite: 3]
    const headingStyle = {
        color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
    };

    return (
        /* Apply the box class to the container div[cite: 3] */
        <div className={styles.box}>
            <h3 style={headingStyle}>{code} - {name}</h3>
            <dl>
                <dt>Started On</dt>
                <dd>{startDate}</dd>
                
                <dt>Current Status</dt>
                <dd>{status}</dd>
                
                <dt>Coach</dt>
                <dd>{coach}</dd>
                
                <dt>Trainer</dt>
                <dd>{trainer}</dd>
            </dl>
        </div>
    );
};