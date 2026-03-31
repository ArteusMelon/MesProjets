import { FormEvent, useState } from "react";

function Login() {

    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [error, setError] = useState<string>("");

    // Fonction de gestion du formulaire à la soumission
    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (!email || !password) {
            setError("Veuillez remplir tous les champs.");
            return;
        }

        // Réinitialiser l'erreur avant d'envoyer la requête
        setError("");

        // Stocker email et password
        const data = { email, password };
        try {
            const response = await fetch("http://localhost:8080/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data),
            });

            // Vérifier si la réponse est OK
            if (response.ok) {
                const result = await response.json();
                // Gestion de la réponse (par exemple, redirection ou affichage d'un message de succès)
                console.log("Connexion réussie", result);
                const tokenTest = result.token;
                // Réinitialiser les champs du formulaire après une connexion réussie
                setEmail("");
                setPassword("");
                localStorage.setItem("token", result.token);
                console.log(tokenTest);
            } else {
                const errorData = await response.json();
                setError(errorData.message || "Erreur de connexion. Essayez à nouveau.");
            }
        } catch (error) {
            setError("Une erreur s'est produite. Veuillez réessayer. (" + error + ")");
            console.log(Response.toString)
        }
    };
    return (
        <div>
            <h2>Connexion</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="password">Mot de passe:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                {error && <p style={{ color: "red" }}>{error}</p>}
                <button type="submit">Se connecter</button>
            </form>
        </div>
    );
}

export default Login;
