import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    // Initialize the component with a list of Post in state using the constructor
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    // Create a method responsible for using the Fetch API to get posts from the provided URL
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                // Map the raw JSON data into our custom Post class structure
                const fetchedPosts = data.map(post => new Post(post.id, post.title, post.body));
                this.setState({ posts: fetchedPosts });
            })
            .catch(error => {
                console.error("Error fetching posts:", error);
            });
    }

    // Implement componentDidMount() hook to make calls to loadPosts()[cite: 2]
    componentDidMount() {
        this.loadPosts();
    }

    // Define componentDidCatch() method to display any error happening in the component as alert messages[cite: 2]
    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert("An error occurred in the component: " + error.toString());
    }

    // Implement render() to display the title and post using heading and paragraphs[cite: 2]
    render() {
        if (this.state.hasError) {
            return <h1>Something went wrong.</h1>;
        }

        return (
            <div>
                <h2>Blog Posts</h2>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ borderBottom: '1px solid #ccc', padding: '10px' }}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;