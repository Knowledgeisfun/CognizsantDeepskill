function DeveloperBios(props) {
    return (
        <div className="card shadow-sm mb-4 border-0">
            <div className="card-body">
                <h4 className="card-title text-primary fw-bold">
                    {props.firstName} {props.lastName}
                </h4>
                <h6 className="card-subtitle mb-3 text-muted">
                    Primary Stack: {props.language}
                </h6>
                <p className="card-text">
                    <span className="badge bg-secondary">Active Developer Since {props.year}</span>
                </p>
            </div>
        </div>
    );
}

export default DeveloperBios;