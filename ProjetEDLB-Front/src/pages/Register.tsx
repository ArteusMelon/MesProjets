import { useState } from 'react';


interface Preference {
    theme: string;
}

interface RegisterForm {
    name: string;
    firstName: string;
    nickName: string;
    preference: Preference[];
    email: string;
    password: string;
    confirmPassword: string;
    registrationDate: Date;
}

const Register = () => {
    const [formData, setFormData] = useState<RegisterForm>({
        name: '',
        firstName: '',
        nickName:'',
        preference: [{theme: 'dark'}],
        email: '',
        password: '',
        confirmPassword: '',
        registrationDate: new Date()
    });

    const [error, setError] = useState<string | null>(null);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError(null);

        if (formData.password !== formData.confirmPassword) {
            setError('Les mots de passe ne correspondent pas.');
            return;
        }

        if (!formData.name || !formData.email || !formData.password || !formData.nickName || !formData.firstName) {
            setError('Tous les champs doivent être remplis.');
            return;
        }

                const formWithDate = {
                    ...formData,
                    registrationDate: new Date(),
                };

        try {
            const response = await fetch("http://localhost:8080/auth/register", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formWithDate),
                
            });

            if (!response.ok) {
                console.log(response)
                throw new Error('Erreur lors de l\'inscription');
            }

            // const data = await response.json();

            alert('Inscription réussie!');
        } catch (error) {
            setError('Une erreur est survenue lors de l\'inscription.');
            console.log(error)
            console.log(Response.toString)
        }
    };

    return (
        <div>
            <h2>Inscription</h2>
            {error && <div className="error">{error}</div>}
            <form onSubmit={handleSubmit}>
            <div>
                    <label htmlFor="firstName">Prénom</label>
                    <input
                        type="text"
                        id="firstName"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="name">Nom</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="nickName">Surnom</label>
                    <input
                        type="text"
                        id="nickName"
                        name="nickName"
                        value={formData.nickName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="password">Mot de passe</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="confirmPassword">Confirmer le mot de passe</label>
                    <input
                        type="password"
                        id="confirmPassword"
                        name="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit"> S'inscrire
                </button>
            </form>
        </div>
    );
};

export default Register;
