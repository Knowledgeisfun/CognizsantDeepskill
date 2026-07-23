
function DeveloperBios(props){
    return(
        <div>
            <h1>FirstName: {props.firstname}</h1>
            <h1>LastName: {props.lastName}</h1>
            <h1>Langauge:{props.langauge}</h1>
            <h1>Year: {props.year}</h1>
        </div>
    );
}

export default DeveloperBios;