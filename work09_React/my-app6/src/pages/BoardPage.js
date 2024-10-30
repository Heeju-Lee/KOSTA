import React from 'react';
import Header from '../components/commons/Header';
import Footer from '../components/commons/Footer';
import Board from '../components/board/Board';

const BoardPage = () => {
    return (
        <div>
            <Header />
            <Board />
            <Footer />
        </div>
    );
};

export default BoardPage;