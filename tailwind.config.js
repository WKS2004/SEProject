module.exports = {
    mode: "jit",
    content: [
        "./**/*.html",
        "./**/*.jsp",
        "./app/**/*.jsp",
        "./app/**/*.html",
        "./src/**/*.java",
    ],
    theme: {
        extend: {},
    },
    plugins: [require("@tailwindcss/forms"), require("@tailwindcss/typography")],
};