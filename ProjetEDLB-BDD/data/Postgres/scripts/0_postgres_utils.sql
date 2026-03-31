CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE TYPE sex_enum AS ENUM ('male', 'female', 'unknown', 'other');
CREATE TYPE order_status AS ENUM (
    'PENDING',      -- En attente
    'CONFIRMED',    -- Confirmée
    'PREPARATION',  -- En preparation
    'SHIPPED',      -- Expédiée
    'DELIVERED',    -- Livrée
    'CANCELLED'     -- Annulée
);
